package com.vam.pkg;
public class VAM {
		int i=0,j=0,b,d=0,k,max=0,min=0,s=0,t=0,sum=0,m,n;
		int p;
		
		double[] rf=new double[20],cf=new double[20],cp=new double[20],rp=new double[20];
		
		double[] a=new double[20];
		
		public  VAM(String func){
			System.out.println(func);
		}
		
		public void sort(double[] a, int n){
			int i,j;
			double temp;
			for(i=0;i<n;i++){
				for(j=i+1;j<n;j++){
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}
			}
		}
		public double[] PenaltyRow(double[][] c,double[] rf,double[] cf,int m,int n)
		{
			for(i=0;i<m;i++){
				k=0;
				if(rf[i]!=1){
					for(j=0;j<n;j++){
						if(cf[j]!=1)
							a[k++]=c[i][j];
					}	
					if(k==1) rp[i]=a[0];
					else{
						sort(a,k);//Sort the row
						rp[i]=a[1]-a[0];//The difference of least two numbers is the penalty
					}
				}
			}//To calculate the penalty array for row
			return rp;
		}
		public double[] PenaltyColumn(double[][] c, double[] rf,double[] cf,int m,int n)
		{
			for(i=0;i<n;i++){
				k=0;
				if(cf[i]!=1){
					for(j=0;j<m;j++){
						if(rf[j]!=1) a[k++]=c[j][i];
					}
					if(k==1) cp[i]=a[0];
					else{
						sort(a,k);//Sort the column
						cp[i]=a[1]-a[0];//The difference of least two numbers is the penalty
					}
				}
			}//To calculate penalty array for column
			return cp;
		}
		public int Voggle(double[][] c,double[] supply,double[] demand,double m,double n){

			b=(int)m;d=(int)n;
			while(b>0 && d>0){
				
				for(i=0;i<m;i++) rp[i]=-1;
				for(i=0;i<n;i++) cp[i]=-1;
				
				PenaltyRow(c,rf,cf,(int)m,(int)n);
				PenaltyColumn(c,rf,cf,(int)m,(int)n);
				
				for(i=0;i<m;i++) a[i]=rp[i];
				for(j=0;j<n;j++) a[i+j]=cp[j];
				
				max=(int)a[0]; 
				p=0;
				for(i=1;i<m+n;i++){
					if(max<a[i]){
						max=(int)a[i];
						p=i;
					}
				}
				min=1000;
				if(p>m-1){
					p=p-(int)m;
					if(cf[p]!=1){
						for(i=0;i<m;i++){
							if(rf[i]!=1){
								if(min>c[i][p]){
									min=(int)c[i][p];
									s=i;
									t=p;
								}
							}
						}
					}
				}//When the supply is lesser than demand
				else{
					if(rf[p]!=1){
						for(i=0;i<n;i++){
							if(cf[i]!=1){
								if(min>c[p][i]){
									min=(int)c[p][i];
									s=p;
									t=i;
								}
							}
						}
					}
				}//When the demand is lesser than supply
				if(supply[s]<demand[t]){
					sum+=c[s][t]*supply[s];
					demand[t]-=supply[s];
					rf[s]=1;
					b--;
				}
				else if(supply[s]>demand[t]){
					sum+=c[s][t]*demand[t];
					supply[s]-=demand[t];
					cf[t]=1;
					d--;
				}
				else if(supply[s]==demand[t]){
					  sum+=c[s][t]*demand[t];
					  cf[t]=1;
					  rf[s]=1;
					  b--;
					  d--;
					  }
			}
				return sum;
		}
}
