package com.exemplu;

import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exemplu.jdbc.Masina;
import com.exemplu.jdbc.MasinaJdbcDao;

@SpringBootApplication
public class SpringJdbcMySqlApplication implements CommandLineRunner{
	 @Autowired
	 MasinaJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcMySqlApplication.class, args);
	}
	 @Override
	 public void run(String... args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		
		do {
			 System.out.println("\nMeniu:");
             System.out.println("1. Adauga o masina");
             System.out.println("2. Sterge o masina");
             System.out.println("3. Căutarea unei mașini după numărul de înmatriculare");
             System.out.println("4. Extragerea unei liste care conţine toate mașinile din baza de date");
             System.out.println("5. Determinarea numărului de mașini din BD care au o anumită marcă");
             System.out.println("6. Determinarea numărului de mașini din BD care au sub 100 000 km");
             System.out.println("7. Extragera unei liste care conţine maşinile mai noi de 5 ani. ");
             System.out.println("8. Exit");
             System.out.print("Introduceti optiunea: ");
             int opt = scanner.nextInt();
             switch(opt)
             {
             case 1: System.out.print("Introduceti nr de inmatriculare: ");
             String nr = scanner.next();
             System.out.print("Introduceti marca: ");
             String marca = scanner.next();
             System.out.print("Introduceti anul: ");
             int anul = scanner.nextInt();
       
             System.out.print("Introduceti culoarea: ");
             String culoarea = scanner.next();
             System.out.print("Introduceti kilometri: ");
             int kilometri = scanner.nextInt();
       
             dao.adaugaMasina(new Masina(nr,marca,anul,culoarea,kilometri));
             
            	 break;
             case 2:System.out.print("Introduceti nr de inmatriculare pt masina de sters: ");
             String nrinm = scanner.next();
           dao.stergeMasina(nrinm);
           System.out.println("Masina a fost stearsa cu succes.");
            	 break;
             case 3:
             System.out.print("Introduceti nr de inmatriculare pentru masina cautata: ");
             String nrin = scanner.next();
             Masina masina = dao.cautareMasina(nrin);
             if (masina != null) {
                 System.out.println("Masina gasita: " + masina);
             } else {
                 System.out.println("Masina cu numarul de inmatriculare " + nrin + " nu a fost gasita.");
             }
      
            	 break;
             case 4: System.out.println("\nToate masinile:");
             dao.findAll().forEach(System.out::println);
            	 break;
             case 5:System.out.print("Introduceti marca: ");
             String mar = scanner.next();
             System.out.print("Nr masini:"+ dao.numararemasini(mar));
            	 break;
             case 6:System.out.print("Nr masini care au mai putin de 100000 kilometri: " + dao.kilomm());
          
            	 break;
             case 7:System.out.print("Masinile mai noi de 5 ani: ");
             
             System.out.println("Masinile mai noi de 5 ani:");
             List<Masina> masiniNoi = dao.masininoi();
             if (masiniNoi.isEmpty()) {
                 System.out.println("Nu exista masini mai noi de 5 ani.");
             } else {
                 masiniNoi.forEach(System.out::println);
             }
            	 break;
             case 8:System.exit(0);
            	 break;
             default:
            	 break;
            	 
             }
			 
		}while(true);
	
		
	 
	 }

}
