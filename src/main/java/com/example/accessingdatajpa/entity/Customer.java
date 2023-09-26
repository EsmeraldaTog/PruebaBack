
package com.example.accessingdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 *  @Entity se usa para marcar una clase como una entidad
 *  que se puede persistir en una base de datos relacional.
 *  Se indica a JPA que la clase representa una tabla
 *  en la base de datos y que los objetos de esta clase
 *  puedan ser alamcenados, actualizados o eliminados en 
 *  dicha tabla. Además, cada instancia se la clase se considera
 *  una fila en la tabla.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id // Indica que el atributo será la clave primaria de la entidad
	// Indica como se generarán automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String firstName;
	private String lastName;
	
	public Customer(String firstName, String lastName) {
		    this.firstName = firstName;
		    this.lastName = lastName;
		  }

}

/*
 * GenerationType.AUTO: Esta estrategia le permite al proveedor de JPA 
 * elegir automáticamente la estrategia de generación más adecuada según 
 * la base de datos y la configuración. El comportamiento exacto puede 
 * variar dependiendo del proveedor utilizado.
 *
 * GenerationType.IDENTITY: Esta estrategia utiliza una columna de identidad 
de la base de datos para generar automáticamente los valores de la clave primaria. 
Es compatible con bases de datos como MySQL que admiten columnas de autoincremento. 
En este caso, la base de datos se encarga de generar y asignar el valor de la clave primaria.

GenerationType.SEQUENCE: Esta estrategia utiliza una secuencia de la base 
de datos para generar automáticamente los valores de la clave primaria. 
Se requiere que la base de datos admita secuencias. El proveedor de JPA 
utiliza la secuencia definida en la base de datos para obtener los valores 
de la clave primaria.

GenerationType.TABLE: Esta estrategia utiliza una tabla especial en la base 
de datos para generar los valores de la clave primaria. Se crea una tabla 
separada que registra los valores generados para cada entidad. El proveedor 
de JPA consulta esta tabla para obtener el próximo valor de la clave primaria.
 * 
 */









/*package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  
  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}*/