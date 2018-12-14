package contrato2;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
        
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        
            System.out.print("Digite o departamento: ");
            String dpName = sc.nextLine();   
            System.out.println("Digite os dados do funcionario");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Nivel: ");
            String nivel = sc.nextLine();
            System.out.print("Base salarial: ");
            double salarioBase = sc.nextDouble();
            Worker funcionario = new Worker(name, WorkerLevel.valueOf(nivel),salarioBase,new Department(dpName));
            
            System.out.print("Quantos contratos este trabalhador tem: ");
            int n = sc.nextInt();
            
            
            for(int i=1; i<=n; i++){        
                
                System.out.println("Digite o " + i + " contrato" );
                System.out.println("Digite a data do contrato (DD/MM/YYYY)");
                Date dataContrato = sdf.parse(sc.next());
                System.out.println("Digite o valor por hora: ");
                double valorHora =  sc.nextDouble();
                System.out.println("Hras trabalhadas:");
                int hora = sc.nextInt();               
                HourContract contratos = new HourContract(dataContrato, valorHora,hora);
                funcionario.addContract(contratos);
            }
                
            System.out.println("Digite o mes e ano para calcular o salario: (MM/YYYY");
            String mesAno = sc.next();
            
            int mes = Integer.parseInt(mesAno.substring(0,2));
            int ano = Integer.parseInt(mesAno.substring(3,7));
            
            System.out.println("Nome: " + name);
            System.out.println("Departamento: " + funcionario.getDepartment().getName());
            System.out.println("Renda em "+ mesAno+ ": " + String.format("R$ %.2f",funcionario.income(ano, mes)));
            
            sc.close();
        }
}
		
