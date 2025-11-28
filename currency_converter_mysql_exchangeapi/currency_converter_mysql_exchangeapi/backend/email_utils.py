from fastapi_mail import FastMail, MessageSchema, ConnectionConfig
from pydantic import EmailStr

# ---------------- Email Configuration ----------------


conf = ConnectionConfig(
    MAIL_USERNAME="jyothin7981@gmail.com",
    MAIL_PASSWORD="cdqa byfo zmlu lxpe",
    MAIL_FROM="jyothin7981@gmail.com",
    MAIL_PORT=587,
    MAIL_SERVER="smtp.gmail.com",
    MAIL_STARTTLS=True,      # previously MAIL_TLS
    MAIL_SSL_TLS=False,      # previously MAIL_SSL
    USE_CREDENTIALS=True,
    VALIDATE_CERTS=True
)

# ---------------- Email Sending Function ----------------
async def send_registration_email(email_to: EmailStr, name: str):
    message = MessageSchema(
        subject="Welcome to CurrencyX!",
        recipients=[email_to],
        body=f"Hello {name},\n\nThank you for registering at CurrencyX!",
        subtype="plain"
    )

    fm = FastMail(conf)  # now conf is defined
    await fm.send_message(message)

async def send_reset_password_email(email: EmailStr, token: str):
    reset_link = f"http://192.168.0.102:5173/reset-password?token={token}"
    message = MessageSchema(
        subject="Reset Your Password",
        recipients=[email],
        body=f"Click the link to reset your password:\n{reset_link}",
        subtype="plain"
    )
    fm = FastMail(conf)
    await fm.send_message(message)
    