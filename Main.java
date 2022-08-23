
public class Main {

    public static void main(String[] args) {

        Empresa unaEmpresa = new Empresa();
        System.out.println(unaEmpresa);
        unaEmpresa.setNombreEmpresa("SalesForce");
        unaEmpresa.setDireccionEmpresa("Calle 24 # 56-87");
        unaEmpresa.setTelefonoEmpresa(311786543);
        unaEmpresa.setNitEmpresa(800765431-2);

        System.out.println("Id: " +unaEmpresa.getNombreEmpresa());
        System.out.println("Email " +unaEmpresa.getDireccionEmpresa());
        System.out.println("Profile: " +unaEmpresa.getDireccionEmpresa());
        System.out.println("Enterprise: " +unaEmpresa.getTelefonoEmpresa());
        System.out.println("RoleName: " +unaEmpresa.getNitEmpresa());

    }
}