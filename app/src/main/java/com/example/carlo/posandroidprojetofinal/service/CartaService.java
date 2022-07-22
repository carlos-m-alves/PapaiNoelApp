package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.model.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CartaService {
    @GET("carta/")
    Call<List<Carta>> buscarTodos();
    @GET("carta/getA")
    Call<List<Relatorio>> brinquedosMaisPedidos();
    @GET("carta/getB")
    Call<List<Relatorio>> criancasPorInstituicao();
    @GET("carta/getC")
    Call<List<Relatorio>> qtdCartasApadrinhadasPorEmpresa();
    @GET("carta/getD")
    Call<List<Relatorio>> quantidadeCartasApadrinhadas();
    @GET("carta/getE")
    Call<List<Relatorio>> quantidadeTotalCartas();
    @PUT("carta/put2")
    Call<Carta> atualizar(@Body Carta carta);
    @PUT("carta/presenteEntregue")
    Call<Carta> presenteEntregue(@Body Carta carta);
    @POST("carta/insereCarta")
    Call<Carta> inserir(@Body Carta carta);
    @GET("carta/idsCartas")
    Call<List<Carta>> buscarTodosIdsCarta();
    @GET("carta/cartasPadrinho/{id}")
    Call<List<Carta>> buscarCartasPadrinho(@Path("id")int idPadrinho);
    @POST("carta/apadrinharVariasCartas/{idPadrinho}/{qtdCartas}")
    Call<List<Carta>> apadrinharVariasCartas(@Path("idPadrinho")int idPadrinho, @Path("qtdCartas")int qtdCartas);
    @POST("carta/apadrinharCarta/{idPadrinho}/{idCarta}")
    Call<List<Carta>> apadrinharCarta(@Path("idPadrinho")int idPadrinho, @Path("idCarta")int idCarta);
    @GET("carta/buscarCartasPorTipoBrinquedo/{idTipoBrinquedo}")
    Call<List<Carta>> buscarCartasPorTipoBrinquedo(@Path("idTipoBrinquedo")int idTipoBrinquedo);
    @GET("carta/getQtdEventos")
    Call<List<Relatorio>> getQtdEventos();
    @GET("carta/qtdInstituicoes")
    Call<List<Relatorio>> qtdInstituicoes();
    @GET("carta/qtdPadrinhos")
    Call<List<Relatorio>> qtdPadrinhos();
}
