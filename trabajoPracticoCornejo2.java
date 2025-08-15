
import java.util.Scanner;

public class trabajoPracticoCornejo2 {

    // Variable global para el ejercicio 11
    static double DESCUENTO_ESPECIAL = 0.10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ejercicio 1: Año bisiesto
        System.out.print("Ingrese un anio: ");
        int anio = sc.nextInt();
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El anio " + anio + " es bisiesto.");
        } else {
            System.out.println("El anio " + anio + " no es bisiesto.");
        }

        // Ejercicio 2: Mayor de tres numeros
        System.out.print("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();
        System.out.print("Ingrese el tercer numero: ");
        int num3 = sc.nextInt();
        int mayor = Math.max(num1, Math.max(num2, num3));
        System.out.println("El mayor es: " + mayor);

        // Ejercicio 3: Clasificacion de edad
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        if (edad < 12) {
            System.out.println("Eres un Ninio.");
        } else if (edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }

        // Ejercicio 4: Calculadora de descuento
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la categoria del producto (A, B o C): ");
        String cat = sc.next().toUpperCase();
        double desc = 0;
        if (cat.equals("A")) desc = 0.10;
        else if (cat.equals("B")) desc = 0.15;
        else if (cat.equals("C")) desc = 0.20;
        double precioFinal = precio - (precio * desc);
        System.out.println("Descuento aplicado: " + (desc * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        // Ejercicio 5: Suma de numeros pares (while)
        int sumaPares = 0;
        int numero;
        do {
            System.out.print("Ingrese un numero (0 para terminar): ");
            numero = sc.nextInt();
            if (numero % 2 == 0 && numero != 0) {
                sumaPares += numero;
            }
        } while (numero != 0);
        System.out.println("La suma de los numeros pares es: " + sumaPares);

        // Ejercicio 6: Contador de positivos, negativos y ceros
        int pos = 0, neg = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el numero " + i + ": ");
            int n = sc.nextInt();
            if (n > 0) pos++;
            else if (n < 0) neg++;
            else ceros++;
        }
        System.out.println("Positivos: " + pos);
        System.out.println("Negativos: " + neg);
        System.out.println("Ceros: " + ceros);

        // Ejercicio 7: Validacion de nota
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota invalida.");
            }
        } while (nota < 0 || nota > 10);
        System.out.println("Nota guardada correctamente.");

        // Ejercicio 8: Calculo precio final con impuesto y descuento
        System.out.print("Ingrese el precio base del producto: ");
        double base = sc.nextDouble();
        System.out.print("Ingrese el impuesto (%): ");
        double imp = sc.nextDouble() / 100;
        System.out.print("Ingrese el descuento (%): ");
        double des = sc.nextDouble() / 100;
        double precioConImpuesto = calcularPrecioFinal(base, imp, des);
        System.out.println("El precio final del producto es: " + precioConImpuesto);

        // Ejercicio 9: Costo envio y total
        System.out.print("Ingrese el precio del producto: ");
        double precioProd = sc.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        System.out.print("Ingrese la zona de envio (Nacional/Internacional): ");
        String zona = sc.next();
        double costoEnvio = calcularCostoEnvio(peso, zona);
        System.out.println("El costo de envio es: " + costoEnvio);
        System.out.println("El total a pagar es: " + calcularTotalCompra(precioProd, costoEnvio));

        // Ejercicio 10: Actualizacion stock
        System.out.print("Ingrese el stock actual del producto: ");
        int stock = sc.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = sc.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = sc.nextInt();
        System.out.println("El nuevo stock es: " + actualizarStock(stock, vendida, recibida));

        // Ejercicio 11: Descuento especial
        System.out.print("Ingrese el precio del producto: ");
        double precioEs = sc.nextDouble();
        calcularDescuentoEspecial(precioEs);

        // Ejercicio 12: Modificacion de array
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        for (double p : precios) System.out.println("Precio: $" + p);
        precios[2] = 129.99;
        System.out.println("Precios modificados:");
        for (double p : precios) System.out.println("Precio: $" + p);

        // Ejercicio 13: Impresion recursiva de array
        double[] preciosRec = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        imprimirArrayRecursivo(preciosRec, 0);
        preciosRec[2] = 129.99;
        System.out.println("Precios modificados:");
        imprimirArrayRecursivo(preciosRec, 0);

        sc.close();
    }

    public static double calcularPrecioFinal(double base, double impuesto, double descuento) {
        return base + (base * impuesto) - (base * descuento);
    }

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else {
            return peso * 10;
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    public static void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public static void imprimirArrayRecursivo(double[] arr, int indice) {
        if (indice < arr.length) {
            System.out.println("Precio: $" + arr[indice]);
            imprimirArrayRecursivo(arr, indice + 1);
        }
    }
}
