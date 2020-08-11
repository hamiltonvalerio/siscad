package mb.amazul.siscad.listeners;

import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import mb.amazul.siscad.model.BaseEntity;
import mb.amazul.siscad.model.LogTrace;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.service.LogTraceService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.service.UsuarioSession;
import mb.amazul.siscad.utils.TransactionType;

public class LogTraceListener {
	
	@Autowired
    LogTraceService logTraceService;

    @Autowired
    UsuarioService usuarioService;
    
    UsuarioSession usuSession = new UsuarioSession();
    
    @PostRemove
    void postDelete(BaseEntity e) {
        createLog(TransactionType.DELETE, e);
    }

    @PostPersist
    void postPersist(BaseEntity e) {
        createLog(TransactionType.CREATE, e);
    }

    @PostUpdate
    void postUpdate(BaseEntity e) {
        createLog(TransactionType.UPDATE, e);
    }

    private void createLog(TransactionType transactionType, BaseEntity e) {
        /*
         * OBSERVAÇÃO 1.
         */
        if (logTraceService == null) {
            ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();

            logTraceService = (LogTraceService) ctx.getBean("logTraceService");
        }

        /*
         * OBSERVAÇÃO 2.
         */
        Usuario usuario = usuSession.getUsuario();

        LogTrace logTrace = new LogTrace();
        /*
         * OBSERVAÇÃO 3.
         */
        String entityName = e.getClass().getAnnotation(Table.class).name();
        if (entityName == null || entityName.isEmpty()) {
            entityName = e.getClass().getSimpleName();
        }

        logTrace.setTransactionType(transactionType);
        logTrace.setEntityName(entityName);
        logTrace.setRegistryId(e.getId());
        logTrace.setExecutedBy(usuario);
        logTrace.setOperationDate(new Date());

        logTraceService.save(logTrace);
    }
}
