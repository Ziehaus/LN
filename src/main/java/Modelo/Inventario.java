package Modelo;

import java.util.HashMap;
import java.util.Map;

public class Inventario {

    private Map<String, Boolean> flags = new HashMap<>();

    public void setFlag(String clave, boolean valor) {
        flags.put(clave, valor);
    }

    public boolean getFlag(String clave) {
        return flags.getOrDefault(clave, false);
    }

    public Map<String, Boolean> getFlags() {
        return flags;
    }
}

