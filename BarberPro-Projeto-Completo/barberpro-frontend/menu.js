document.addEventListener('DOMContentLoaded', () => {
  const hamburger = document.querySelector('.hamburger-menu');
  const navUl = document.querySelector('nav ul');

  // Verifica se os elementos existem na página
  if (hamburger && navUl) {
    hamburger.addEventListener('click', () => {
      // Adiciona/remove a classe que mostra a sidebar
      navUl.classList.toggle('sidebar-active');

      // Adiciona/remove a classe que anima o ícone
      hamburger.classList.toggle('active');
    });

    // Opcional: Fechar o menu ao clicar em um link (bom para one-page sites ou navegação rápida)
    navUl.querySelectorAll('a').forEach(link => {
      link.addEventListener('click', () => {
        navUl.classList.remove('sidebar-active');
        hamburger.classList.remove('active');
      });
    });
  }
});