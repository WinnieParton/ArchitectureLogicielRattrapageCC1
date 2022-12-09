Bonjour à vous,
*************** 
Pour tester les API web voici les etapes à faire:

1- Creer un client:

    Methode: POST
    Url: /api/clients
    Body: 
        {
            "firstName":"koum wo",
            "lastName": "winnie"
        }

2- Pour voir la liste des client:

    Methode: GET
    Url: /api/clients

3- Pour valider un panier

    Methode: POST
    Url: /api/carts
    Body: 
        {
            "amount":100,
            "clientId": "8d16fc67-597b-487e-985f-1af08d4b4bad"
        }

4- Pour voir la liste de tous les paniers

    Methode: GET
    Url: /api/carts

5- Pour annuler un panier

    Methode: POST
    Url: /api/carts/cancel
    Body: 
        {
            "cartId":"2a945775-122a-4d24-8e2e-04765151ad44"
        }

*******************************************************

                                Enoncé du projet:

***********************************
        

Concernant le module Architecture Logicielle, ci-dessous le sujet du CC1 que je vous donne:

"Créer un programme en Java qui permet de gérer un panier d'achat d'un site e-commerce"

Consignes
Utilisation des patterns Value Object, Value Object ID, CQS, Repository, DTO, Service, Controller
Ne pas utiliser de base de données mais un InMemoryRepository
Respect de la visibilité des classes, des méthodes et des propriétés
Limitez-vous à quelques attributs de l'objet Panier (ID, Date, Montant)
Limitez-vous à quelques méthodes de services : validation et annulation du panier
L'usage d'un Controlleur de type Web est optionnel
Respecter un découpage en couche
L'usage d'une architecture Hexagonal est optionnel
Ne pas y consacrer plus de 3 heures.