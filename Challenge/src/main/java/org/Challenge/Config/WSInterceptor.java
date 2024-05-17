package org.Challenge.Config;

import org.Challenge.Entities.BitacoraEntity;
import org.Challenge.Services.PokemonService;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class WSInterceptor implements EndpointInterceptor {
    private final HttpServletRequest httpServletRequest;
    private final PokemonService pokemonService;


    public WSInterceptor(HttpServletRequest httpServletRequest, PokemonService pokemonService) {
        this.httpServletRequest = httpServletRequest;
        this.pokemonService = pokemonService;

    }

    private String getIp(){
        return httpServletRequest.getRemoteAddr();
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        Flag.setSaveFlag(true);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {
        if(Flag.shouldSave()){
            Date date = new Date();
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setAccion(messageContext.getRequest().toString().split("}")[1]);
            bitacoraEntity.setIp_origen(this.getIp());
            bitacoraEntity.setFecha_movimiento(new Timestamp(date.getTime()));
            pokemonService.saveRequest(bitacoraEntity);
        }
        Flag.clear();
    }
}
