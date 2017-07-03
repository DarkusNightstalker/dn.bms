/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darkus Nightmare
 */
@Entity
@Table(name = "direct_access")
@XmlRootElement
public class DirectAccess implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Short id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "loadable_bean", length = 50, nullable = false)
    private String loadableBean;
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "icon_path", length = 50, nullable = false)
    private String icon;

    /**
     * @return the id
     */
    public Short getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the loadableBean
     */
    public String getLoadableBean() {
        return loadableBean;
    }

    /**
     * @param loadableBean the loadableBean to set
     */
    public void setLoadableBean(String loadableBean) {
        this.loadableBean = loadableBean;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
