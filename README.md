# SIW-SpringBoot: Catering

Questo è lo sviluppo di un progetto proposto dal docente per il corso di Sistemi Informativi Su Web. Si tratta della progettazione e implementazione del sistema informativo di una società che offre servizi di Catering. Le specifiche del progetto sono riportate di seguito:

- La società offre diversi buffet: ogni buffet è proposto da uno chef e contiene uno o più piatti. Ogni buffet ha un nome e una descrizione. Uno chef può proporre uno o   più buffet. Per ogni chef sono di interesse nome, cognome, nazionalità.

- Per ogni piatto proposto in un buffet sono di interesse il nome, una descrizione, l'elenco degli ingredienti. Per ogni ingrediente è di interesse il nome, l'origine,     una descrizione.

- Possono accedere al sistema utenti generici e un amministratore.

- L’amministratore, previa autenticazione, può inserire, modificare, cancellare le informazioni relative ai buffet, agli chef, ai piatti.

- L’utente generico può accedere alle informazioni della società attraverso diversi percorsi di navigazione, opportunamente predisposti (ad esempio, per chef, oppure per   buffet, etc.).

# Casi d'Uso

**Amministratore**
- [x] Login Amministratore Tramite Credenziali
- [x] Logout Amministratore
- [x] Inserimento Chef
- [x] Inserimento Buffet
- [x] Inserimento Piatto
- [x] Cancellazione Chef
- [x] Cancellazione Buffet
- [x] Cancellazione Piatto
- [x] Modifica Chef
- [x] Modifica Buffet
- [ ] Modifica Piatto

**Utente Generico**
- [x] Registrazione Utente Generico Tramite Credenziali
- [x] Login Utente Generico Tramite Credenziali
- [ ] Login Utente Generico Tramite Terze Parti (Es. Gmail)
- [x] Logout Utente Generico
- [x] Visualizzazione Chef
- [x] Visualizzazione Buffet
- [x] Visualizzazione Piatti
- [x] Visualizzazione Ingredienti
