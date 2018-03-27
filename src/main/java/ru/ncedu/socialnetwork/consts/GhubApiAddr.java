package ru.ncedu.socialnetwork.consts;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GhubApiAddr {
    private Map addreses;
    private static final String BASE_URL = "https://api.github.com";
    private static final String USERS_URL = BASE_URL + "/users/";

    public GhubApiAddr() throws IllegalAccessException {
        addreses = new HashMap();

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            addreses.put(field.getName(), field.get(this));
        }
    }

    public Map getAddreses(){
        return addreses;
    }
}
