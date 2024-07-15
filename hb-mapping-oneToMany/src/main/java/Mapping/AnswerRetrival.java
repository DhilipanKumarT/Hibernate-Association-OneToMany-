package Mapping;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class AnswerRetrival
{
	public static void main(String[]args)
	{
		Transaction tr=null;
		try(Session ses=HBUtil.getsf().openSession())
		{
			tr=ses.beginTransaction();
			org.hibernate.query.Query<Question> qry=ses.createQuery("from Question",Question.class);
					List<Question> qi=qry.list();
			for(Question q:qi) {
				System.out.println(q.getId()+"\t"+q.getQuestion());
				List<Answer>ans=q.getAnswers();
				for(Answer b:ans)
				{
					System.out.println(b.getId()+"\t"+b.getAnswername()+"\t"+b.getPostedBy());
				}
			}
			tr.commit();
			ses.close();
			}
			 catch(Exception e)
		     {
				  e.printStackTrace();
			 }
		}
	}