
public class Main {

    public static void main(String[] args) {

        Empresa unaEmpresa = new Empresa();
        System.out.println(unaEmpresa);

        unaEmpresa.setNombreEmpresa("SalesForce");
        unaEmpresa.setDireccionEmpresa("Calle 24 # 56-87");
        unaEmpresa.setTelefonoEmpresa(311786543);
        unaEmpresa.setNitEmpresa(800765431-2);

        System.out.println("Dirección " +unaEmpresa.getDireccionEmpresa());
        System.out.println("Telefono: " +unaEmpresa.getTelefonoEmpresa());
        System.out.println("Nombre: " +unaEmpresa.getNombreEmpresa());
        System.out.println("Nit: " +unaEmpresa.getNitEmpresa());

    }
}