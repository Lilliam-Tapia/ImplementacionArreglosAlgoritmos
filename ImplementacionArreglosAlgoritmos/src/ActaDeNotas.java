import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.SpringLayout;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class ActaDeNotas {
    public static void main(String [] args){
     Scanner  lector = new Scanner(System.in);
     double nota = 35.00, Sis = 30.00,Pcurso = 0.00;
     int intentos = 3,cantidadDesersiones = 0,matricula = 0,n;
     double notaSistematicos = 0.0, notaPrimerParcial = 0.0;
     boolean cerrado = false;
     ArrayList<Double> notas = new ArrayList<Double>();
     double notaMaxima = 0;
     double notaMinima = 100,porcentajeAprobados = 0,promedioNotas = 0;
     double sumaNotas = 0,porcentajeReprobados = 0;
     int cantidadAprobados = 0,cantidadreprobados = 0;
     String[][] matriz = new String[4][8];
     int[] notas1 = new int[5]; 
     int[] intervalos = new int[5];
  
        for (int i = 0; i < 1; i++) {
            System.out.print("Nombre del curso: ");
            matriz[i][0] = lector.nextLine().toUpperCase();

            System.out.print("Grupo: ");
            matriz[i][1] = lector.nextLine().toUpperCase();

            System.out.print("Período lectivo: ");
            matriz[i][2] = lector.nextLine().toUpperCase();

            System.out.print("Código de asignatura: ");
            matriz[i][3] = lector.nextLine();

            System.out.print("Carrera: ");
            matriz[i][4] = lector.nextLine().toUpperCase();

            System.out.print("Código de programa de asignatura: ");
            matriz[i][5] = lector.nextLine();

            System.out.print("Modalidad de asignatura: ");
            matriz[i][6] = lector.nextLine();

            System.out.print("Código del curso: ");
            matriz[i][7] = lector.nextLine();
        }
        System.out.println("Datos Generales");
        for (int i = 0; i < 1; i++) {

            System.out.printf("%-50s %-40s %-40s\n", "Curso:           "+matriz[i][0], "Cod.Curso:       "+matriz[i][7],"Primer Parcial:    "+nota);
            System.out.printf("%-50s %-40s %-40s\n", "Período Lectivo: "+matriz[i][2], "Grupo:           "+matriz[i][1],"Segundo Parcial:   "+nota);
            System.out.printf("%-50s %-40s %-40s\n", "Carrera:         "+matriz[i][4], "Cod.Asiganatura: "+matriz[i][3],"Sistematicos:      "+Sis);
            System.out.printf("%-50s %-40s %-40s\n", "Modalidad:       "+matriz[i][6], "Cod.Programa:    "+matriz[i][5],"Proyecto de curso: "+Pcurso);
            System.out.println();
        }
    
        System.out.print("Ingrese la Cantidad de estudiantes: ");
        n = lector.nextInt();
         double[] notasFinales = new double [n];
         double [] notasFinales1 = new double [n];
          double [] notasFinales2 = new double [n];
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Datos del estudiante " + (i + 1) + ":");
            System.out.print("Número de carnet: ");
            String id = lector.next().toUpperCase();
            System.out.print("Nombres: ");
            String firstName = lector.next();
            System.out.print("Apellidos: ");
            String lastName1 = lector.nextLine();
            String lastName2 = lector.nextLine();
            do {
                System.out.print("Ingrese la nota del primer parcial (máximo 35.00): ");
                try {
                    notaPrimerParcial = lector.nextDouble();
                    if (notaPrimerParcial < 0 || notaPrimerParcial > 35) {
                        System.out.println("Nota inválida.Ingrese la nota correcta de los sistematicos: ");
                        intentos--;
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("El valor debe ser un número. Intente nuevamente.");
                    lector.next(); 
                    intentos--;
                } catch (NoSuchElementException e) {
                    System.out.println("Debe introducir un valor.");
                    intentos--;
                    cerrado = true; 
                }
            } while (intentos  > 0 && !cerrado); 
            
            if (intentos == 0) {
                System.out.println("Se superó el número máximo de intentos. El programa finalizará.");
                break;
            }

            do {
            System.out.print("Ingrese la nota de los sistemáticos (máximo 30.00): ");
            try {
                notaSistematicos = lector.nextDouble();
                if (notaSistematicos < 0 || notaSistematicos > 30) {
                    System.out.println("Nota inválida.Ingrese la nota correcta de los sistematicos: ");
                    intentos--;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor debe ser un número. Intente nuevamente.");
                lector.next(); 
                intentos--;
            } catch (NoSuchElementException e) {
                System.out.println("Debe introducir un valor.");
                intentos--;
                cerrado = true; 
            }
        } while (intentos  > 0 && !cerrado); 
        
        if (intentos == 0) {
            System.out.println("Se superó el número máximo de intentos. El programa finalizará.");
            break;
        }
            double notaSegundoParcial = 0.0,notaProyecto = 0.0;
          
              while (intentos > 0) {
            try {
                System.out.print("¿La asignatura lleva proyecto de curso? (S/N): ");
                String respuestaProyecto = lector.next();

                if (respuestaProyecto.equalsIgnoreCase("S")) {
                    System.out.print("Ingrese la nota del proyecto (máximo 35.00): ");
                    notaProyecto = lector.nextDouble();
                    if (notaProyecto < 0 || notaProyecto > 35) {
                        throw new InputMismatchException();
                    }
                } else {
                    System.out.print("Ingrese la nota del segundo parcial (máximo 35.00): ");
                    notaSegundoParcial = lector.nextDouble();
                    if (notaSegundoParcial < 0 || notaSegundoParcial > 35) {
                        throw new InputMismatchException();
                    }
                }
              break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: La nota debe ser un número no negativo y no mayor a 35.00");
                intentos--;
                lector.nextLine(); 
            }
        }

        if (intentos == 0) {
            System.out.println("Se han agotado los intentos. Terminando programa.");
            break;
        } 
    
            
            double notaFinal = notaPrimerParcial + notaSistematicos + notaSegundoParcial + notaProyecto;
            notasFinales[i] = notaFinal;

            if (notaFinal < 60) {
                System.out.print("Ingrese la nota del examen de primera convocatoria (máximo 70.00): ");
                double notaExamenPrimeraConvocatoria = lector.nextDouble();
                while (notaExamenPrimeraConvocatoria < 0 || notaExamenPrimeraConvocatoria > 70) {
                    System.out.print("Nota inválida. Ingrese la nota del examen de primera convocatoria (máximo 70.00): ");
                    notaExamenPrimeraConvocatoria = lector.nextDouble();
                }

                notaFinal = notaSistematicos + notaExamenPrimeraConvocatoria;
                notasFinales1[i] = notaFinal;

                if (notaFinal < 60) {
                    System.out.print("Ingrese la nota del examen de segunda convocatoria (máximo 100.00): ");
                    double notaExamenSegundaConvocatoria = lector.nextDouble();
                    while (notaExamenSegundaConvocatoria < 0 || notaExamenSegundaConvocatoria > 100) {
                        System.out.print("Nota inválida. Ingrese la nota del examen de segunda convocatoria (máximo 100.00): ");
                        notaExamenSegundaConvocatoria = lector.nextDouble();
                    }

                    notaFinal = notaExamenSegundaConvocatoria;
                    notasFinales2[i] = notaFinal;
                }
            }

            boolean aprobado = notaFinal >= 60;
            System.out.print("¿Desertó el curso? (Sí/No): ");
            String respusta = lector.next();
            boolean  deserted = respusta.equalsIgnoreCase("Si");
            if(deserted){
                cantidadDesersiones++;
            }
            students.add(new Student(id,lastName1,lastName2,firstName, notaFinal, aprobado, deserted));
            System.out.println("\nNota Final: " + notaFinal);
            System.out.println("¿Aprobado?: " + (aprobado));


            notas.add(notaFinal);
            sumaNotas += notaFinal;

            if (notaFinal > notaMaxima) {
                notaMaxima = notaFinal;
            }

            if (notaFinal < notaMinima) {
                notaMinima = notaFinal;
            }

            if (notaFinal >= 60) {
                cantidadAprobados++;
            }
            if(notaFinal < 60){
                cantidadreprobados++;
            }
            
         promedioNotas = sumaNotas / n;
         porcentajeAprobados = ((double) cantidadAprobados / n) * 100;
         porcentajeReprobados = ((double)cantidadreprobados/n)*100;
         matricula = n - cantidadDesersiones;
        }
        Collections.sort(students);
        System.out.println("Carnet\t\tNombres y Apellidos\t\tNota Final\tAprobado\tDeserción");
        for (Student student : students) {
            System.out.printf("%10s\t%s %s %s\t%.2f\t\t%-10s\t%-10s\n", student.id, student.lastName1,student.lastName2,student.firstName, student.notafinal, student.aprobado ? "Sí" : "No", student.deserted ? "Sí" : "No");
        }
        
        System.out.println("Datos Estadísticos");
        System.out.printf("%-14s: %s    %-14s: %s   %-14s: %s%n", "Matricula Inicial ", n, "Matricula Efectiva ", matricula, "No Deserciones ", cantidadDesersiones);
        System.out.printf("%-14s: %.2f%%   %-14s: %s   %-14s: %s%n", "% Aprobados ", porcentajeAprobados, "Aprobados ", cantidadAprobados, "Reprobados  ", cantidadreprobados);
        System.out.printf("%-14s%-24s%n", "% Reprobados: "+porcentajeAprobados, "% Promedio: "+promedioNotas);
        
        System.out.println("Ordenar de forma ascendente o descendente.");
        System.out.println("1.Por nota Final");
        System.out.println("2.Por nota Final despues de primera convocatoria.");
        System.out.println("3.Por nota Final despues de segunda convocatoria.");
        System.out.println("4.Rango de notas.");
        System.out.print("Ingrese una opcion: ");
        int opc = lector.nextInt();

        
        switch (opc) {
            case 1:
            Arrays.sort(notasFinales);
            System.out.println("Notas finales ordenadas de manera ascendente: " + Arrays.toString(notasFinales));

            Double[] notasFinalesObj = Arrays.stream(notasFinales).boxed().toArray(Double[]::new);
            List<Double> notasFinalesList = Arrays.asList(notasFinalesObj);
            Collections.sort(notasFinalesList);
            Collections.reverse(notasFinalesList);
            notasFinalesObj = notasFinalesList.toArray(new Double[notasFinalesList.size()]);
            notasFinales = Arrays.stream(notasFinalesObj).mapToDouble(Double::doubleValue).toArray();
            System.out.println("Notas finales ordenadas de manera descendente: " + Arrays.toString(notasFinales));
            break;
            case 2:

             Arrays.sort(notasFinales1);
             System.out.println("Notas finales ordenadas de manera ascendente: " + Arrays.toString(notasFinales1));
            
             Double[] notasFinales1Obj = Arrays.stream(notasFinales1).boxed().toArray(Double[]::new);
             List<Double> notasFinales1List = Arrays.asList(notasFinales1Obj);
             Collections.sort(notasFinales1List, Collections.reverseOrder());
             notasFinalesObj = notasFinales1List.toArray(new Double[notasFinales1List.size()]);
             notasFinales1 = Arrays.stream(notasFinales1Obj).mapToDouble(Double::doubleValue).toArray();
             System.out.println("Notas finales ordenadas de manera descendente: " + Arrays.toString(notasFinales1));

            break;
            case 3:
             Arrays.sort(notasFinales2);
             System.out.println("Notas finales ordenadas de manera ascendente: " + Arrays.toString(notasFinales2));
            
             Double[] notasFinales2Obj = Arrays.stream(notasFinales2).boxed().toArray(Double[]::new);
             List<Double> notasFinales2List = Arrays.asList(notasFinales2Obj);
             Collections.sort(notasFinales2List, Collections.reverseOrder());
             notasFinalesObj = notasFinales2List.toArray(new Double[notasFinales2List.size()]);
             notasFinales2 = Arrays.stream(notasFinales2Obj).mapToDouble(Double::doubleValue).toArray();
             System.out.println("Notas finales ordenadas de manera descendente: " + Arrays.toString(notasFinales2));

            break;

            case 4:
             
         for (int i = 0; i < n ; i++){ 
            notasFinales[i] =  lector.nextInt();
            if(notasFinales[i] >=0 && notasFinales[i] <= 59){
                intervalos[0]++;
            }else if (notasFinales[i] >= 60 && notasFinales[i] <= 69){
                intervalos[1]++;
            }else if (notasFinales[i] >= 70 && notasFinales[i] <= 79){
                intervalos[2]++;
            }else if (notasFinales[i] >= 80 && notasFinales[i] <= 89){
                intervalos[3]++;
            }else if (notasFinales[i] >= 90 && notasFinales[i] <= 100){
                intervalos[4]++;
            }
            }
            System.out.println("intervalos de puntuacion y número de estudiantes.");
            System.out.println("0-59: " +intervalos[0]+  " Estudiantes.");
            System.out.println("60-69: " +intervalos[1]+ " Estudiantes.");
            System.out.println("70-79: " +intervalos[2]+ " Estudiantes.");
            System.out.println("80-89: " +intervalos[3]+ " Estudiantes.");
            System.out.println("90-100: "+intervalos[4]+ " Estudiantes.");
            break;
            
        }
       
    }

    private static class Student implements Comparable<Student> {
        private final String id;
        private final String firstName;
        private final String lastName1;
        private final String lastName2;
        private final double notafinal;
        private final boolean aprobado;
        private final boolean deserted;

        public Student(String id, String firstName, String lastName1,String lastName2, double notafinal, boolean aprobado, boolean deserted) {
            this.id = id;
            this.firstName = firstName;
            this.lastName1 = lastName1;
            this.lastName2 = lastName2;
            this.notafinal = notafinal;
            this.aprobado = aprobado;
            this.deserted = deserted;
        }

        @Override
        public int compareTo(Student other) {
            int result = lastName1.compareTo(other.lastName1);
            if (result == 0) {
                result = lastName2.compareTo(other.lastName2);
                if (result == 0) {
                   result = firstName.compareTo(other.firstName);
                }
            }
            return result;
        }
   }
   
}