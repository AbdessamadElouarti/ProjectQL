package ma.ensa.ql;

import java.util.List;

import ma.ensa.dao.Idao;
import ma.ensa.model.Transaction;
import ma.ensa.model.User;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ItemWriterImpl implements ItemWriter<Transaction>
{
	Idao dao;
	
	@Autowired
	public void setDao(Idao dao) 
		{
			this.dao = dao;
		}

		public void write(List<? extends Transaction> items)throws Exception
		{
				for (Transaction item:items) 
				{
					dao.persist(item);
					User user=(User)dao.getUserByLogin(item.getUserLogin());
					int rest=user.getMontantTotale()-item.getMontant();
					user.setMontantTotale(rest);	
					dao.updateRecord(user);
				}
		}
}
