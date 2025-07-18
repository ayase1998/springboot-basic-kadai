const stripe = Stripe('pk_test_51RfXcXH1qxjEYgacGaxOBA7s2iuliunTIggg1tSGgJMqhpRpjdyKw7SxG9NacZrcrTMlanUw9bwYs5kAtEqDeVJD00CGcmywWd');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});