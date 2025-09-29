Ce projet consiste à concevoir et développer une application en Java permettant de gérer les agents, leurs départements et leurs paiements.
L’application offre la possibilité à un responsable de département d’ajouter ou modifier des agents, d’enregistrer différents types de paiements (salaire, prime, bonus, indemnité) selon les règles d’éligibilité, et de suivre l’historique complet des paiements avec calculs automatiques et identification des anomalies.

Contexte du projet
L’organisation souhaite digitaliser la gestion des paiements de ses agents et le suivi des départements. L’objectif est de fournir aux agents et aux responsables de département un outil simple, fiable et sécurisé pour gérer les paiements (salaire, primes, bonus, indemnités), tout en assurant un suivi précis et des statistiques détaillées.

Vous êtes chargé de concevoir et développer une application console Java permettant de simuler la gestion des paiements des agents, en respectant les règles de gestion et les bonnes pratiques de programmation orientée objet, tout en exploitant les collections, l’API Java Time, les Streams et la persistance via JDBC.

Objectifs / Fonctionnalités principales
Pour les agents :

Consulter leurs informations personnelles et leur département.
Afficher l’historique de leurs paiements : salaire, prime, bonus, indemnité.
Filtrer et trier les paiements par type, montant ou date.
Calculer le total de leurs paiements.
Pour les responsables de département :

Créer, modifier ou supprimer un département et associer un responsable.
Ajouter, modifier ou supprimer un agent et l’affecter à un département.
Ajouter un paiement à un agent :
Salaire et prime : ajoutables pour tous les agents.
Bonus et indemnité : ajoutables uniquement si l’agent est éligible (Responsable de département ou Directeur) et que l’action ou événement requis est réalisé.
Consulter et filtrer les paiements d’un agent ou de tous les agents du département.
Calcul automatique du total et de la moyenne des paiements par agent et par département.
Identifier les paiements inhabituels ou incorrects.
Règles de gestion

Chaque agent appartient à un seul département.
Chaque département possède un responsable (Agent).
Un département peut contenir plusieurs agents.
Un agent peut avoir plusieurs paiements.
Gestion des exceptions : montant négatif, agent ou département introuvable, paiement inexistant, conditions non remplies pour bonus ou indemnité.
Modélisation des entités (POO / UML-ready)

Personne (classe abstraite) : nom, prénom, email, motDePasse.
Agent : idAgent, typeAgent (Enum), département (association), paiements (ArrayList<Paiement>).
Département : idDepartement, nom, responsable (Agent), agents (ArrayList<Agent>).
Paiement : idPaiement, type (Salaire, Prime, Bonus, Indemnité), montant, date, motif/événement, agent (association).
Bonus et indemnité contiennent un attribut conditionValidee (boolean) indiquant si l’action ou événement requis a été accompli.
TypeAgent (Enum) : OUVRIER, RESPONSABLE_DEPARTEMENT, DIRECTEUR, STAGIAIRE.
TypePaiement (Enum) : SALAIRE, PRIME, BONUS, INDEMNITE.
Architecture technique et technologies utilisées (MVC)

Modèle (Model) : classes Agent, Département, Paiement avec attributs et méthodes métier.
Vue (View) : interface console pour afficher menus et informations.
Contrôleur (Controller) : classes de gestion des interactions, traitement des commandes et validation des données.
Collections : Collections pour agents, départements et paiements.
Streams et Lambda : filtrage, tri, agrégation.
Functional Interfaces : Predicate, Function, Consumer, Supplier pour la logique métier.
Method References (::) pour simplifier le code.
Optional pour gérer les valeurs absentes.
Java Time API pour gérer les dates de paiement.
Gestion des exceptions : montant négatif, agent ou département introuvable, paiement inexistant, conditions non respectées pour bonus ou indemnité.
Persistance : JDBC pour stocker et récupérer les données.
User Stories
Pour les agents :

En tant qu’agent, je veux consulter mes informations personnelles et mon département.
En tant qu’agent, je veux voir l’historique complet de mes paiements.
En tant qu’agent, je veux filtrer et trier mes paiements par type, montant ou date.
En tant qu’agent, je veux calculer le total de mes paiements.
Pour les responsables de département :

En tant que directeur, je veux créer, modifier ou supprimer un département et associer un responsable.
En tant que responsable, je veux ajouter, modifier ou supprimer un agent et l’affecter à un département.
En tant que responsable, je veux ajouter un paiement à un agent :
Salaire et prime librement selon le contrat.
Bonus et indemnités uniquement si l’agent est éligible et que l’action requise est validée.
En tant que responsable, je veux consulter et filtrer les paiements d’un agent ou de tous les agents du département.
En tant que responsable, je veux identifier les paiements inhabituels ou incorrects.
