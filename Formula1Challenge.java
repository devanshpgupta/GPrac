import java.util.LinkedList;
public class Formula1Challenge {
	public LinkedList<Team> createTeams(int nos)
	{
		LinkedList<Team> teams=new LinkedList<Team>();
		for(int i=1;i<=nos;i++)
		{
			Team t=new Team(i);
			teams.add(t);
		}
		return teams;
	}
	
	private void createRace(int dist, LinkedList<Team> team) {
	int reass=2;
	int range=10;
	int start=0;
	int finalSpeed=0;
	float completionTime=0;
	for(Team t:team)
	{
		System.out.println(dist+t.lagDistance);
		while(t.distanceCovered<=(dist+t.lagDistance))
		{
		t.completionTime=t.completionTime+(float)(0.34);
		t.distanceCovered=(float) (t.distanceCovered+ t.getTopSpeed()*(0.34));
		//System.out.println(t.teamNos+":"+t.completionTime+"\t"+t.distanceCovered);
		//break;
		//completionTime=(float)((dist+t.lagDistance)/t.getTopSpeed());
		//t.completionTime=completionTime;
		}
	}
	for(Team t:team)
	{
	System.out.println(t.teamNos+":"+t.completionTime+"\t"+t.distanceCovered);
	}
	}
	
	public static void main(String[] args) {
	Formula1Challenge f1=new Formula1Challenge();
	LinkedList<Team> teams=f1.createTeams(5);
	f1.createRace(50,teams);
	}
}
class Team
{
	int teamNos=0;
	int topSpeed=0;
	int acceleration=0;
	float hf=0.8f;
	int nitro=0;
	int finalSpeed=0;
	float completionTime=0;
	float lagDistance=0;
	float distanceCovered=0;
	
	public Team(int i) {
		this.topSpeed = 150+10*i;
		this.acceleration = 2*i;
		this.teamNos=i;
		this.lagDistance=(float) 0.2*(i-1);
	}
	public int getTopSpeed() {
		return topSpeed;
	}
	public int getAcceleration() {
		return acceleration;
	}
	public int getNitro() {
		return nitro;
	}
	public void setNitro(int speed) {
		if(speed*2>getTopSpeed())
		this.nitro = getTopSpeed();
		else
			this.nitro = speed*2;	
	}
	public int getFinalSpeed() {
		return finalSpeed;
	}
	public void setFinalSpeed(int finalSpeed) {
		this.finalSpeed = finalSpeed;
	}
	public float getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(float completionTime) {
		this.completionTime = completionTime;
	}
	public float getLagDistance() {
		return lagDistance;
	}
	public float getDistanceCovered() {
		return distanceCovered;
	}
	public void setDistanceCovered(float distanceCovered) {
		this.distanceCovered = this.distanceCovered+distanceCovered;
	}
	
}