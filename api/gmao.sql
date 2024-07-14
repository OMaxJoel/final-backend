-- Création des tables

CREATE TABLE Role (
    ID_Role INT PRIMARY KEY,
    Nom_Role VARCHAR(50) -- 'Technicien', 'Chef de Service', 'Chef de Section'
);

CREATE TABLE Utilisateur (
    ID_Utilisateur INT PRIMARY KEY,
    Nom_Utilisateur VARCHAR(100),
    Mot_De_Passe VARCHAR(255)
);

CREATE TABLE Utilisateur_Role (
    ID_Utilisateur INT,
    ID_Role INT,
    PRIMARY KEY (ID_Utilisateur, ID_Role),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur),
    FOREIGN KEY (ID_Role) REFERENCES Role(ID_Role)
);

CREATE TABLE Competence (
    ID_Competence INT PRIMARY KEY,
    Description TEXT
);

CREATE TABLE Technicien_Competence (
    ID_Technicien INT,
    ID_Competence INT,
    PRIMARY KEY (ID_Technicien, ID_Competence),
    FOREIGN KEY (ID_Technicien) REFERENCES Utilisateur(ID_Utilisateur),
    FOREIGN KEY (ID_Competence) REFERENCES Competence(ID_Competence)
);

CREATE TABLE Type_Intervention (
    ID_Type_Intervention INT PRIMARY KEY,
    Nom VARCHAR(100),
    Description TEXT
);

CREATE TABLE Fournisseur (
    ID_Fournisseur INT PRIMARY KEY,
    Nom VARCHAR(255),
    Adresse TEXT,
    Telephone VARCHAR(20)
);

CREATE TABLE Equipement (
    ID_Equipement INT PRIMARY KEY,
    Nom VARCHAR(255),
    Description TEXT,
    Date_Acquisition DATE,
    Statut VARCHAR(50),
    Emplacement VARCHAR(255)
);

CREATE TABLE Piece_Rechange (
    ID_Piece INT PRIMARY KEY,
    Nom VARCHAR(255),
    Quantite INT,
    Emplacement VARCHAR(255),
    ID_Equipement INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement)
);

CREATE TABLE Contrat (
    ID_Contrat INT PRIMARY KEY,
    Nom_Fournisseur VARCHAR(255),
    Date_Debut DATE,
    Date_Fin DATE,
    ID_Equipement INT,
    ID_Fournisseur INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement),
    FOREIGN KEY (ID_Fournisseur) REFERENCES Fournisseur(ID_Fournisseur)
);

CREATE TABLE Alerte (
    ID_Alerte INT PRIMARY KEY,
    Date_Alerte DATE,
    Type VARCHAR(100),
    Description TEXT,
    ID_Equipement INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement)
);

CREATE TABLE Ordre_Travail (
    ID_Ordre INT PRIMARY KEY,
    Date_Ordre DATE,
    Description TEXT,
    Priorite VARCHAR(50),
    Statut VARCHAR(50),
    ID_Equipement INT,
    ID_Utilisateur INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur)
);

CREATE TABLE Maintenance (
    ID_Maintenance INT PRIMARY KEY,
    Type VARCHAR(50),
    Frequence VARCHAR(100),
    Description TEXT,
    Date_Debut DATE,
    Date_Fin DATE,
    ID_Equipement INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement)
);

CREATE TABLE Intervention (
    ID_Intervention INT PRIMARY KEY,
    Date_Intervention DATE,
    Statut VARCHAR(50),
    Description TEXT,
    ID_Equipement INT,
    ID_Utilisateur INT,
    ID_Type_Intervention INT,
    FOREIGN KEY (ID_Equipement) REFERENCES Equipement(ID_Equipement),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur),
    FOREIGN KEY (ID_Type_Intervention) REFERENCES Type_Intervention(ID_Type_Intervention)
);

CREATE TABLE Historique_Intervention (
    ID_Historique INT PRIMARY KEY,
    ID_Intervention INT,
    Date DATE,
    Action TEXT,
    ID_Utilisateur INT,
    FOREIGN KEY (ID_Intervention) REFERENCES Intervention(ID_Intervention),
    FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur)
);

-- Création des contraintes d'intégrité référentielle supplémentaires

ALTER TABLE Intervention
ADD CONSTRAINT FK_Intervention_Type_Intervention
FOREIGN KEY (ID_Type_Intervention) REFERENCES Type_Intervention(ID_Type_Intervention);
