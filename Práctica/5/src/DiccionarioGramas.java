import java.util.*;

public class DiccionarioGramas {
    public Map<String, ArrayList<String>> getGramas(String cade) {
        String cadena = "#" + cade + "$";
        Map<String, ArrayList<String>> gramas = new LinkedHashMap<>();
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < cadena.length(); i++) {
            char[] caracteres = new char[2];
            caracteres[0] = cadena.charAt(i);
            if(caracteres[0] == '$') {
                break;
            }
            caracteres[1] = cadena.charAt(i+1);
            String grama = new String(caracteres);
            lista.add(grama);
            gramas.put(grama, new ArrayList<>(lista));
        }
        return gramas;
    }
}
