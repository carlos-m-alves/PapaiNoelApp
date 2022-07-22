package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;
import com.example.carlo.posandroidprojetofinal.service.CartaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartaFacade {
    public static void buscarTodos(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.43.176:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void brinquedosMaisPedidos(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.brinquedosMaisPedidos();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void criancasPorInstituicao(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.criancasPorInstituicao();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void atualizar(Carta cartaAtualizar, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<Carta> call = service.atualizar(cartaAtualizar);
        call.enqueue(new Callback<Carta>() {
            public void onResponse(Call<Carta> call, Response<Carta> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Carta> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void inserir(Carta cartaCadastrar, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<Carta> call = service.inserir(cartaCadastrar);
        call.enqueue(new Callback<Carta>() {
            public void onResponse(Call<Carta> call, Response<Carta> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Carta> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void buscarTodosIdsCarta(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.buscarTodosIdsCarta();
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void buscarCartasPadrinho(int idPadrinho, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.buscarCartasPadrinho(idPadrinho);
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void insereVariasCartas(int idPadrinho, int qtdCartas, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.apadrinharVariasCartas(idPadrinho, qtdCartas);
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void apadrinharCarta(int idPadrinho, int idCarta, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.apadrinharCarta(idPadrinho, idCarta);
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void buscarCartasPorTipoBrinquedo(int idTipoBrinquedo, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Carta>> call = service.buscarCartasPorTipoBrinquedo(idTipoBrinquedo);
        call.enqueue(new Callback<List<Carta>>() {
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Carta>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void getQtdEventos(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.getQtdEventos();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void qtdInstituicoes(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.qtdInstituicoes();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void qtdPadrinhos(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.qtdPadrinhos();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void qtdCartasApadrinhadasPorEmpresa(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.qtdCartasApadrinhadasPorEmpresa();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void quantidadeCartasApadrinhadas(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.quantidadeCartasApadrinhadas();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void presenteEntregue(Carta c, final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<Carta> call = service.presenteEntregue(c);
        call.enqueue(new Callback<Carta>() {
            public void onResponse(Call<Carta> call, Response<Carta> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }
            public void onFailure(Call<Carta> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void quantidadeTotalCartas(final CartaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CartaService service = retrofit.create(CartaService.class);
        Call<List<Relatorio>> call = service.quantidadeTotalCartas();
        call.enqueue(new Callback<List<Relatorio>>() {
            public void onResponse(Call<List<Relatorio>> call, Response<List<Relatorio>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Relatorio>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
