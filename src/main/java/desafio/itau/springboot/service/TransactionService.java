package desafio.itau.springboot.service;

import desafio.itau.springboot.entity.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    @Value("${estatistica.tempo.segundos}")
    private long segundos;

    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDataHora()
                        .isAfter(now.minusSeconds(segundos)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }

}
