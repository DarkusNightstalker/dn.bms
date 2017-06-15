package cs.bms.util;

import java.util.HashMap;
import java.util.Map;

public class UbigeoUtil {

    private static final Map<String, String> homologateSubregions;
    private static final Map<String, String> homologateRegions;
    private static final Map<String, String> homologateDistrict = new HashMap();

    static {
        homologateDistrict.put("HUAYLLAY GRANDE", "HUAYLLAY-GRANDE");
        homologateDistrict.put("TOMAY KICHWA", "TOMAY-KICHWA");
        homologateDistrict.put("RINCONADA LLICUAR", "RINCONADA-LLICUAR");
        homologateDistrict.put("CARMEN DE LA LEGUA REYNOSO", "CARMEN DE LA LEGUA-REYNOSO");

        homologateSubregions = new HashMap();
        homologateSubregions.put("PROV. CONST. DEL CALLAO", "CALLAO");

        homologateRegions = new HashMap();
        homologateRegions.put("PROV. CONST. DEL CALLAO", "CALLAO");
    }


    public static String homologateSubregion(String key) {
        return (String) homologateSubregions.get(key);
    }

    public static String getRegionFromAddress(String address) {
        if (address.endsWith("CALLAO")) {
            return "PROV. CONST. DEL CALLAO";
        }
        if (address.endsWith("DIOS")) {
            return "MADRE DE DIOS";
        }
        if (address.endsWith("LIBERTAD")) {
            return "LA LIBERTAD";
        }
        if (address.endsWith("MARTIN")) {
            return "SAN MARTIN";
        }
        String[] sp = address.split(" ");
        return sp[(sp.length - 1)];
    }

    public static String homologateRegion(String key) {
        return (String) homologateRegions.get(key);
    }

    public static String homologateDistrict(String key) {
        return (String) homologateDistrict.get(key);
    }
}
