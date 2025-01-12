package com.exemplu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exemplu.entity.Masina;
import com.exemplu.repository.MasinaSpringDataJpaRepository;

@SpringBootApplication

public class SpringDataJpaMySQLApplication implements CommandLineRunner{
	@Autowired
	 MasinaSpringDataJpaRepository repository;
	
	public static void main(String[] args) {
		
		 SpringApplication.run(SpringDataJpaMySQLApplication.class, args);
		 
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
		             System.out.print("Masina adaugata: " + repository.save(new Masina(nr,marca,anul,culoarea,kilometri)));
		         
		            	 break;
		             case 2:System.out.print("Introduceti nr de inmatriculare pt masina de sters: ");
		             String nrinm = scanner.next();
		            repository.deleteByNr(nrinm);

		            	 break;
		             case 3:
		             System.out.print("Introduceti nr de inmatriculare pentru masina cautata: ");
		             String nrin = scanner.next();
		             Masina masina = repository.findByNr(nrin);
		             if (masina == null) {
		                 System.out.println("Masina nu a fost găsită!");
		             } else {
		                 System.out.println("Masina găsită: " + masina);
		             }

		           
		            	 break;
		             case 4: System.out.println("\nToate masinile:");
		             repository.findAll().forEach(System.out::println);
		            	 break;
		             case 5:System.out.print("Introduceti marca: ");
		             String mar = scanner.next();
		             System.out.print("Masinile cu marca: " + repository.countByMarca(mar));
		          
		            	 break;
		             case 6:long kilometr=100000;
		            	 System.out.print("Nr masini care au mai putin de 100000 kilometri: " + repository.countByKilometriLessThan(kilometr));
		             
		          
		            	 break;
		             case 7:System.out.print("Masinile mai noi de 5 ani cu springdatajpa: ");
		          
		             int anu = 2019;
		             System.out.print("Masinile mai noi de 5 ani: "+  repository.findByAnulGreaterThan(anu));
		            	 break;
		             case 8:System.exit(0);
		            	 break;
		             default:
		            	 break;
		            	 
		             }
					 
				}while(true);
			
		 }
}
