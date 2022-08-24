public class Main {

    public static void main(String[] args) {

        MovimientoDinero entrada1 =new MovimientoDinero();
        entrada1.setMontoMovimiento(1200000);
        entrada1.setConceptoMovimiento("Pago alquiler");
        entrada1.setUsuarioMovimiento("Administrador");

        System.out.println("El valor del movimiento fue : " +entrada1.getMontoMovimiento());
        System.out.println("El concepto del movimiento fue : " +entrada1.getConceptoMovimiento());
        System.out.println("El usuario del movimiento fue: " +entrada1.getUsuarioMovimiento());
