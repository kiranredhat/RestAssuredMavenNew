package Gson;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setEmpNo(201);
		emp.setName("kiran");
		emp.setSalary(60000);
//		String JsonEmployee=JsonUtil.convertJavaToJson(emp);
//		System.out.println(JsonEmployee);
		Gson gs=new Gson();
		String JsonEmployee=gs.toJson(emp);
		System.out.println(JsonEmployee);
		
		System.out.println("========================");
		//Employee emp1=JsonUtil.convertJsonToJava(JsonEmployee, Employee.class);
//		Employee emp1=JsonUtil.convertJsonToJava(JsonEmployee, Employee.class);
//		System.out.println("empNo:" +emp1.getEmpNo() +" name:"+emp1.getName()+" salary:"+emp1.getSalary());

		
		Gson gs1=new Gson();
		Employee emp1= gs1.fromJson(JsonEmployee, Employee.class);
		System.out.println("empNo:" +emp1.getEmpNo() +" name:"+emp1.getName()+" salary:"+emp1.getSalary());
		
	}

}
