public class EmployeeReportFormatter extends ReportFormatter {

    Employee anEmployee;

    // Since FormatType will also be used by the parent class
    //    best to define it separately
    //FormatType formatType;

    public EmployeeReportFormatter(Employee emp, FormatType f) {
       //Since the parent has its own constructor now
        super(emp, f);
    }
    
    public void getFormattedEmployee() {
        System.out.println(getFormattedValue());
    }

    //Has now been defined in the parent
    //public String getFormattedValue() {}
    
}
