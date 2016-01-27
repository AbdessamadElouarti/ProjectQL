package ma.ensa.ql;

import ma.ensa.model.Transaction;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;


 public class ItemProcessorImpl implements ItemProcessor<Transaction,Transaction>
 
{
	public Transaction process(final Transaction transactionInput)throws Exception
	{
		return transactionInput; 
	}

}
 