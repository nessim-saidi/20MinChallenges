package org.dhbw.service.student.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Course
 * 
 * @Entity: Diese Plain-Old-Java-Object (POJO) Klasse soll von JPA gemanaged werden. Das heißt,
 *          JPA legt automatisch passende Datenbank-Tabellen an und schreibt, liest und löscht die
 *          Entitäten auf Anfrage (z.B. über ein Repository).
 * @Data:   Verwende Lombok, um automatisch Getter und Setter für die Klassenvariablen zu erzeugen,
 *          sowie Konstruktoren für die Klasse bereit zu stellen. Diese werden unter anderem von
 *          JPA beim Speichern in und Auslesen aus den Datenbank-Tabellen benötigt. 
 */
@Entity
@Data
public class Course {

    /**
     * Dieses Feld ist eine @Id, deren Wert automatisch bestimmt wird (@GeneratedValue).
     * Die Strategie "Identity" ermittelt automatisch die nächste freie Nummer dieser Tabelle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Titel des Kurses
     */
    private String title;
    
    /**
     * Hier sind keine Zugriffsmethoden (Getter/Setter) für die Klassenvariablen. Diese werden aufgrund der 
     * Annotation @Data von Lombok generiert zur Verfügung gestellt. So wird z.B. ein getTitle() erstellt. 
     */

    @ManyToMany(mappedBy = "courseList")
    @JsonIgnoreProperties("courseList")
    private List<Student> enrolledStudents;
}