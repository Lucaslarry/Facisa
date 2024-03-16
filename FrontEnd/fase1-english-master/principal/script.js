document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('indexForm').addEventListener('submit', function (event) {
        event.preventDefault();
        window.location.href = 'greeting.html';
    });
});
