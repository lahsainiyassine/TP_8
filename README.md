Exercice 1 — Système de Paiement Extensible
Ce qui est fait
Définition de l'interface PaymentMethodimposant un contrat uniforme pour tout moyen de règlement : pay(), refund()et getName().

Implémentation concrète de trois canaux aux comportements et données propres :

CreditCard: gestion du titulaire, numéro de carte et débit/remboursement sur vente.

PayPal: validation par adresse email et vente dédiée.

Bitcoin: gestion d'une adresse de portefeuille ( wallet ) et montants en BTC.

Création du composant métier PaymentProcessor:

Stockez les moyens de paiement dans un tableau manuel redimensionné dynamiquement ( System.arraycopy).

Effectuez les transactions (tentative de débit puis remboursement partiel) sans connaître l'implémentation sous-jacente des moyens de paiement.

Exercice 2 — Système de Notification Extensible
Ce qui est fait
Conception de l'interface Notificationdéfinissant l'envoi de message, le nom du canal et un niveau de priorité numérique :

SMSNotification: priorité haute (valeur 2).

EmailNotification: priorité normale (valeur 1).

PushNotification: priorité basse (valeur 0).

Implémentation de NotificationManagerpour la diffusion multi-canal :

Enregistrement flexible des canaux dans un tableau dynamique.

Diffusion ordonnée ( broadcast) : copie défensive du tableau actif et tri par priorité décroissante via Arrays.sortet Comparator.comparingInt(Notification::getPriority).reversed().

Découplage total : l'ajout futur d'un canal (ex : Slack, Webhook) ne nécessite aucune modification du gestionnaire.