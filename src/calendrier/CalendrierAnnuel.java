package calendrier;

public class CalendrierAnnuel {
	public Mois[] calendrier;
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		calendrier[0]=new Mois("janvier",31);
		calendrier[1]=new Mois("février",28);
		calendrier[2]=new Mois("mars",31);
		calendrier[3]=new Mois("avril",30);
		calendrier[4]=new Mois("mai",31);
		calendrier[5]=new Mois("juin",30);
		calendrier[6]=new Mois("juillet",31);
		calendrier[7]=new Mois("aout",31);
		calendrier[8]=new Mois("septembre",30);
		calendrier[9]=new Mois("octobre",31);
		calendrier[10]=new Mois("novembre",30);
		calendrier[11]=new Mois("decembre",31);
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		if (estLibre(jour,mois)) {
			calendrier[mois].reserver(jour);
			return true;
		}
		return false;
	}

	public class Mois {
		private String nom;
		private boolean[] jour;
		
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			jour=new boolean[nbJours];
		}
		
		private boolean estLibre(int jour) {
			return !this.jour[jour-1];
		}
		
		private void reserver(int jour) {
			if(this.jour[jour-1]) {
				throw new IllegalStateException();
			}
			this.jour[jour-1]=true;
		}
	}
}
