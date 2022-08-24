
public class MainEmpleado {

    public static void main(String[] args) {

        Empleado unEmpleado = new Empleado();

        //unEmpleado.setId(1020435693);
        unEmpleado.setNombreEmpleado("Jairo Morales Rodriguez.com");
        unEmpleado.setEmailEmpleado("jmr1309@gmail.com");
        unEmpleado.setEmpresaEmpleado("ForceSales");
        unEmpleado.setRolEmpleado("Desarrolador");

        //System.out.println("Id: " +unEmpleado.getId());
        System.out.println("Nombre Empleado " +unEmpleado.getNombreEmpleado());
        System.out.println("Email: " +unEmpleado.getEmailEmpleado());
        System.out.println("Empresa: " +unEmpleado.getEmpresaEmpleado());
        System.out.println("Rol del Empleado: " +unEmpleado.getRolEmpleado());