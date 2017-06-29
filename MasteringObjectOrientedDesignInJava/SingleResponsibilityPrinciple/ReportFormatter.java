import java.lang.reflect.*;

// Not abstract anymore
public class ReportFormatter {

    // Well, this wasn't in the UML, so don't follow everything to the letter
    String formattedValue;

    // the minus means the methods are private
    private String convertObjectToXML(Object object) {

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
    
    // the minus means the methods are private
    private String convertObjectToCSV(Object object) {

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
    
    // Not abstract, but applicable to any child
    public String getFormattedValue() {
        return formattedValue;
    }

    // Since the functions are now private, you will need a way to call them somehow

    // Create a constructor
    public ReportFormatter(Object object, FormatType formatType) {
        switch(formatType) {
            case XML:
                formattedValue = convertObjectToXML(object);
                break;
            case CSV:
                formattedValue = convertObjectToCSV(object);
                break;
        }
    }

}
