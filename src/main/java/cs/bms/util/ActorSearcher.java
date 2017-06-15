package cs.bms.util;

import cs.bms.bean.util.PNotifyMessage;
import cs.bms.model.Actor;
import cs.bms.util.exception.CaptchaFailedException;
import cs.bms.util.exception.IdentityException;
import gkfire.web.util.BeanUtil;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.websocket.SessionException;

public abstract class ActorSearcher
        implements Serializable {

    protected String identityNumber;
    protected String captcha;
    protected boolean webSearchValid;
    protected Actor actor;
    protected String image64;
    protected IdentitySearch identitySearch;

    public ActorSearcher() {
        this.identitySearch = new IdentitySearch() {
            public void init(int length) {
                super.init(length);
                if (this.imageCaptcha != null) {
                    ActorSearcher.this.image64 = new String(Base64.getEncoder().encode(this.imageCaptcha));
                } else {
                    ActorSearcher.this.image64 = null;
                }
            }
        };
    }

    public void search() {
        this.identityNumber = this.identityNumber.trim();
        this.actor = searchActorInService();
        if ((this.actor == null) || (this.actor.getName() == null) || (this.actor.getName().length() == 0)) {
            if (this.identityNumber.length() == 8) {
                this.identitySearch.init(this.identityNumber.length());
                this.webSearchValid = false;
                this.captcha = "";
                this.actor = null;
                BeanUtil.exceuteJS("open_search_actor();");
            } else {
                caseRUC();
            }
        }
    }

    protected abstract Actor searchActorInService();

    protected abstract void saveOrUpdateByDNI(String paramString);

    protected abstract void caseRUC();

    protected abstract void saveOrUpdateByRUC(String[] paramArrayOfString);

    public void searchByWeb() throws Exception {
        try {
            if (this.identityNumber.length() == 8) {
                String name = (String) this.identitySearch.search(this.identityNumber, this.captcha);
                if (name == null) {
                    throw new IdentityException("El dni no existe");
                }
                saveOrUpdateByDNI(name);

                this.webSearchValid = true;
            } else {
                String[] data = (String[]) this.identitySearch.search(this.identityNumber, this.captcha);
                if (data[0] == null) {
                    throw new IdentityException("El ruc no existe");
                }
                saveOrUpdateByRUC(data);
                this.webSearchValid = true;
            }
        } catch (CaptchaFailedException ex) {
            PNotifyMessage.errorMessage("Texto de imagen incorrecto");
            this.webSearchValid = false;
            this.captcha = "";
            ex.printStackTrace();
        } catch (IdentityException ex) {
            PNotifyMessage.errorMessage(ex.getMessage());
            this.webSearchValid = true;
            this.actor = null;
            ex.printStackTrace();
        } catch (SessionException ex) {
            PNotifyMessage.errorMessage("Sesion expirada");
            this.webSearchValid = false;
            this.actor = null;
            this.captcha = "";
            this.identitySearch.init(this.identityNumber.length());
            ex.printStackTrace();
        }
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isWebSearchValid() {
        return this.webSearchValid;
    }

    public void setWebSearchValid(boolean webSearchValid) {
        this.webSearchValid = webSearchValid;
    }

    public Actor getActor() {
        return this.actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getImage64() {
        return this.image64;
    }

    public void setImage64(String image64) {
        this.image64 = image64;
    }

    public IdentitySearch getIdentitySearch() {
        return this.identitySearch;
    }

    public void setIdentitySearch(IdentitySearch identitySearch) {
        this.identitySearch = identitySearch;
    }
}
