import java.util.Scanner;
public class UsaPrismaT
{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        //Declaración de variables
        float baseMayor;
        float baseMenor;
        float alturaTrapecio;
        float ladoTrapecio;
        float alturaPrisma;
        
        System.out.println("Bienvendio al calculador de area y volumen de Prisma Trapezoidales\n\n");
        
        PrismaTrapezoidal tra1 = new PrismaTrapezoidal(15.3f , 10.4f , 20 , 25.1f , 123);
        PrismaTrapezoidal tra2;
        
        System.out.println("--Datos Trapecio 1--");
        System.out.println(tra1.toString()+"\nVolumen: "+tra1.calcularVolumen()+"\nArea: "+tra1.calcularArea());
        System.out.println("-------------");
        
        System.out.println("Captura de datos del 2do. prisma:");
        System.out.println("Ingresa la base mayor: ");
        baseMayor = scanner.nextFloat();
        System.out.println("Ingresa la base menor: ");
        baseMenor = scanner.nextFloat();
        System.out.println("Ingresa la altura del trapecio: ");
        alturaTrapecio = scanner.nextFloat();
        System.out.println("Ingresa el lado del trapecio: ");
        ladoTrapecio = scanner.nextFloat();
        System.out.println("Ingresa la altura del prisma: ");
        alturaPrisma = scanner.nextFloat();
        
        tra2 = new PrismaTrapezoidal(baseMayor,baseMenor,alturaTrapecio,ladoTrapecio,alturaPrisma);
        
        System.out.println("--Datos Trapecio 2--");
        System.out.println(tra2.toString()+"\nVolumen: "+tra2.calcularVolumen()+"\nArea: "+tra2.calcularArea());
        System.out.println("-------------------");

        scanner.close();
    }
}
