package eleven.opdracht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Dit programma is gemaakt als sollicitatie assessment voor Eleven.
 * @author Suzy Margaretha
 *
 * Een gebruiker krijgt een lijst met actiepunten te zien en kan vervolgens nieuwe actiepunten aanmaken, bestaande actiepunten wijzigen of verwijderen. 
 * De status van een actiepunt kan aangepast worden door op de knop 'Ja' te drukken in de kolom Voltooid?
 * Een data.sql file wordt gebruikt om de H2 database te vullen met voorbeeld waarden. Database is in memory, als de gebruiker de service herstart zijn de nieuwe/gewijzigde
 * gegevens gewist en begint de gebruiker weer met een lege lijst aan actiepunten (m.u.v. de 2 voorbeeld queries die worden aangemaakt via data.sql).
 * Het is mogelijk om via application.propertiesde database gegevens op te slaan zodat wijzigingen de herstart van het programma overleven. Helaas geen tijd
 * meer gehad om dit werkend te krijgen.
 * Gebruikersdocumentatie is meegestuurd in de file Gebruikersdocumentatie SpringTodoApp.docx.
 * Geen tijd meer gehad om TodoControllerTest class werkend te krijgen, daarom gecomment. 3 kleine Tests in TodoRepoTest geschreven om er toch wat mee te oefenen en
 * in ieder geval een paar werkende tests te hebben in het programma.
 */
@SpringBootApplication
public class SpringTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTodoAppApplication.class, args);
	}
}
