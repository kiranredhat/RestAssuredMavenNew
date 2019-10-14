package JavaToJsonAndJsonJava;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setEmpNo(201);
		emp.setName("kiran");
		emp.setSalary(60000);
		String JsonEmployee=JsonUtil.convertJavaToJson(emp);
		System.out.println(JsonEmployee);
		
		System.out.println("========================");
		Employee emp1=JsonUtil.convertJsonToJava(JsonEmployee, Employee.class);
		System.out.println("empNo:" +emp1.getEmpNo() +" name:"+emp1.getName()+" salary:"+emp1.getSalary());
		
	}

}
