let data;

        document.addEventListener("DOMContentLoaded", function() {
            fetch('/chamarFuncaoJava')
                .then(response => response.json())
                .then(responseData => {
                    data = responseData; // Atribua os dados da resposta à variável data
                    const selectElement = document.getElementById("objetoSelect");
                    
                    data.forEach((objeto, index) => {
                        const option = document.createElement("option");
                        option.value = index; // Use o índice como valor para identificar o objeto selecionado
                        option.text = objeto.nome; // Exibe o nome do objeto na lista
                        selectElement.appendChild(option);
                    });
                })
                .catch(error => {
                    console.error('Erro:', error);
                    alert('Ocorreu um erro ao obter os dados');
                });

            document.getElementById("editarBotao").addEventListener("click", () => {
                const selectElement = document.getElementById("objetoSelect");
                const selectedIndex = selectElement.value;
                
                if (selectedIndex !== "") {
                    const objetoSelecionado = data[selectedIndex];
                    const queryParams = Object.keys(objetoSelecionado).map(key => `${encodeURIComponent(key)}=${encodeURIComponent(objetoSelecionado[key])}`).join("&");
                    const url = `/editar-pessoa?${queryParams}`;
                    window.location.href = url;
                } else {
                    alert("Por favor, selecione uma pessoa para editar.");
                }
            });
        });