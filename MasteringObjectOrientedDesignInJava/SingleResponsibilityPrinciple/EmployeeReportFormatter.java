public class EmployeeReportFormatter extends ReportFormatter {

    Employee anEmployee;
    FormatType formatType;
    public enum FormatType {
        CSV,
        XML
    }

    public EmployeeReportFormatter(Employee emp, FormatType f) {
        anEmployee = emp;
        formatType = f;
    }
    
    public void getFormattedEmployee() {
        System.out.println(getFormattedValue());
    }

    public String getFormattedValue() {
        if (formatType == FormatType.CSV) {
            return convertObjectToCSV(anEmployee);
        }
        else if (formatType == FormatType.XML) {
            return convertObjectToXML(anEmployee);
        }
        return "";
    }
    
}
