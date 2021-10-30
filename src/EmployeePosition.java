public interface EmployeePosition {
    default String getJobTitle(){
        return null;
    }

    default void calcSalary(){}
}
