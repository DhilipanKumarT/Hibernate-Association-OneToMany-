package Mapping;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HBUtil 
	{
	    private static SessionFactory sf;
	    public static StandardServiceRegistry sr;
	    public static SessionFactory getsf()
		{
			if(sf==null)
			{
				try
				{
					sr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
					Metadata md=new MetadataSources(sr).buildMetadata();
					sf=md.buildSessionFactory();
				}
				catch(HibernateException h)
				{
					h.printStackTrace();
				}
			}
			return sf;
		}

	}
