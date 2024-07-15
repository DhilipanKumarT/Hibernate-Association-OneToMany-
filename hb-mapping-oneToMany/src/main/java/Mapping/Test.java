package Mapping;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class Test
{
	public static void main(String args[])
	{
		Transaction tr=null;
		try(Session ses=HBUtil.getsf().openSession())
		{
			tr=ses.beginTransaction();
			Question q1=new Question();
			q1.setQuestion("What is HiberNate?");
			Question q2=new Question();
			q2.setQuestion("What is Entity Class?");
			
			Answer a1=new Answer(101,"Hb is an ORM","Dhilipan(mama)");
			Answer a2=new Answer(102,"Hb implements   JPA","Dhinesh");
			Answer b1=new Answer(201,"Entity class is asimple java class","Deepak Raj");
			Answer b2=new Answer(202,"POJO classes are called Entity Class","Kugan");
			List<Answer> l1=new ArrayList<Answer>();
			l1.add(a1);
			l1.add(a2);
			List<Answer> l2=new ArrayList<Answer>();
			l2.add(b1);
			l2.add(b2);
			q1.setAnswers(l1);
			q2.setAnswers(l2);
			ses.merge(q1);
			ses.merge(q2);
			//ses.persist(q1);
			//ses.persist(q2);
			tr.commit();
			ses.close();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
