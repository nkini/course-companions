import java.lang.reflect.*;

public abstract class ReportFormatter {

    public String convertObjectToXML(Object object) {

        String xml = "";
        xml += "<" + object.getClass().getName() + ">\n";
       
        try { 
            Field[] fields = object.getClass().getDeclaredFields();
            for(Field field : fields) {
                xml += "    <" + field.getName() + ">" + field.get(object).toString() + "</" + field.getName() + ">\n";
            }
            
            xml += "</" + object.getClass().getName() + ">";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return xml;

    }
    
    public String convertObjectToCSV(Object object) {

        String[] fieldValues = new String[object.getClass().getDeclaredFields().length];
        
        try {
            int i = 0;
            Field[] fields = object.getClass().getDeclaredFields();
            for(Field field : fields) {
                fieldValues[i]  = field.get(object).toString();
                i += 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return String.join(",", fieldValues);

    }
    
    public abstract String getFormattedValue();

}
