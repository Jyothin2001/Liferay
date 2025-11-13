import secrets

# Generate a secure random string
secret = secrets.token_urlsafe(32)
print(secret)
