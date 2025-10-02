import DAO.Impl.AgentDaoImpl;
import DAO.Impl.DepartementDaoImpl;
import config.DB;
import controller.AgentController;
import controller.AuthController;
import controller.DirecteurController;
import controller.ResponsableController;
import models.*;
import service.IAuthService;
import service.IPaiementService;
import service.Ipml.AgentServiceIpml;
import service.Ipml.PaiementServiceImpl;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.math.BigInteger.ZERO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

//        AuthController authController = new AuthController();
//
//        Agent loggedAgent = authController.seConnecter();
//
//        if (loggedAgent.getTypeAgent().equals(TypeAgent.DIRECTEUR)) {
//            DirecteurController directeurController = new DirecteurController();
//            directeurController.commander();
//        } else if (loggedAgent.getTypeAgent().equals(TypeAgent.RESPONSABLE_DEPARTEMENT)) {
//            ResponsableController responsableController = new ResponsableController();
//            responsableController.commander();
//        } else if (loggedAgent.getTypeAgent().equals(TypeAgent.OUVRIER)) {
//            AgentController agentController = new AgentController();
//            agentController.commander(loggedAgent);
//        }

        IPaiementService paiementService = new PaiementServiceImpl();
        List<Paiement> paiements = paiementService.paiements();
//        double a =paiements.stream().filter(paiement -> paiement.getDate().equals(new Date())).map(Paiement::getMontant).reduce(0d, Double::sum);
//
//        double pays = paiements.stream().filter(paiement -> paiement.getDate().equals(LocalDate.of(2025, 10, 1))).map(Paiement::getMontant).mapToDouble(Double::doubleValue).sum();
//        Scanner scanner = new Scanner(System.in);
//        int annee = scanner.nextInt();

//        double totalAnnuelle = paiements.stream()
//                .filter(paiement ->  paiement.getDate().isAfter(LocalDate.of(annee, 01, 01)) && paiement.getDate().isBefore(LocalDate.of(annee, 12, 31)))
//                .map(paiement -> paiement.getMontant())
//                .mapToDouble(Double::doubleValue)
//                .sum();

        Scanner scanner1 = new Scanner(System.in);
        TypePaiement typePay = TypePaiement.valueOf(scanner1.nextLine());

        long countByType = paiements.stream()
                .filter(paiement -> paiement.getTypePaiement().equals(typePay))
                .count();

        System.out.println("Nombre de " + typePay + " affecté(e)s " + " est " + countByType);


    }
}