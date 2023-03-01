package com.estudioprueba.menualumnos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class MenualumnosApplication {

	public static int cantidad(int cantidad, String tipo, Scanner ingreso) {
		do {
			System.out.print("Ingrese la cantidad de " + tipo + " : ");
			cantidad = ingreso.nextInt();
			if (cantidad <= 0) {
				System.out.print("La cantidad de " + tipo + " debe ser mayor a 0.");
			}
		} while (cantidad <= 0);
		return cantidad;
	}

	public static int inicioMenu(Scanner ingreso, int opcion) {
		System.out.println("================Inicio Menú================");
		do {
			System.out.println("Bienvenido/a");
			System.out.println("Ingrese 1 para obtener el promedio de las notas por alumno.");
			System.out.println("Ingrese 2 para saber si el alumno aprueba o reprueba.");
			System.out
					.println("ingrese 3 para saber si el promedio del alumno está por sobre o denajo del promedio general.");
			System.out.println("Ingrese 0 para salir del menú.");
			System.out.print("Ingrese su opción: ");
			opcion = ingreso.nextInt();
		} while (opcion < 0 || opcion > 3);
		return opcion;
	}

	public static void opcion1(HashMap<String, ArrayList<Double>> libroClase) {
		for (String i : libroClase.keySet()) {
			Double promedioAlumno = promedioNotas(libroClase.get(i));
			System.out.println("El promedio del alumno " + i + " es: " + promedioAlumno);
		}
	}

	public static Double promedioNotas(ArrayList<Double> notas) {
		Double suma = 0.0;
		for (int i = 0; i < notas.size(); i++) {
			suma += notas.get(i);
		}
		Double promedio = suma / notas.size();
		return promedio;
	}

	public static void main(String[] args) {
		/*
		 * vamos a pedir al usuario que ingrese la cantidad de alumnos
		 * a los cuales les asignará una nota
		 * luego de que ingrese la cantidad de alumno y la cantidad de notas por alumnos
		 * se le mostrará un menú.
		 * opciones del menú:
		 * mostrar el promedio de notas
		 * mostrar si la nota es aprobatria y reprobatoria
		 * mostrar si la nota está por sobre o por debajo del promedio del curso
		 */

		/*
		 * solicitar al usuario la cantidad de alumnos*
		 * Solicitar el nombre de cada alumnos*
		 * solicitar la cantidad de notas de por alumno*
		 * ingresar notas por alumno*
		 * definir la nota aprobatoria*
		 * sacar el promedio por alumnos y general
		 * verificar si el promedio del alumnos esta por sobre o
		 * por debajo del promedio general
		 * verificar si la nota aprueba o reprueba
		 * hacer el menú con solo 3 opciones con cero finalizando el menú
		 * hacer validaciones sobre las notas y la cantidad de alumnos
		 * verificar que el promedio se calcule previamente antes de las
		 * operaciones que lo requieren
		 */

		Scanner ingreso = new Scanner(System.in);

		String nomAlumno = "";
		Double notaAprobatoria = 4.0;
		int opcion = 1;

		ArrayList<Double> notasAlumnos = new ArrayList<Double>();
		HashMap<String, ArrayList<Double>> libroClase = new HashMap<String, ArrayList<Double>>();

		int cantAlumnos = 0;
		int cantNotas = 0;
		int alumnIngresados = cantidad(cantAlumnos, "alumnos", ingreso);
		int notasIngresadas = cantidad(cantNotas, "notas", ingreso);

		for (int i = 1; i <= alumnIngresados; i++) {
			ingreso.nextLine();
			System.out.println("Ingrese nombre del alumno " + i + " : ");
			nomAlumno = ingreso.nextLine();
			for (int x = 1; x <= notasIngresadas; x++) {
				System.out.println("Ingrese nota " + x + " del alumno " + nomAlumno + " : ");
				Double nota = ingreso.nextDouble();
				notasAlumnos.add(nota);
			}
			libroClase.put(nomAlumno, notasAlumnos);
		}

		while (opcion != 0) {
			inicioMenu(ingreso, opcion);

			if (opcion == 1) {
				opcion1(libroClase);
			}
		}

	}

}
