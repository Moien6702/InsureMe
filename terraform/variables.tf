variable "aws_region" {
  description = "AWS region"
  default     = "us-east-1"
}

variable "ami_id" {
  description = "AMI ID (Ubuntu 22.04 LTS)"
  default     = "ami-0c02fb55956c7d316"
}

variable "instance_type" {
  description = "EC2 instance type"
  default     = "t2.micro"
}

variable "key_name" {
  description = "Your AWS key pair name for SSH"
}

variable "allowed_ip" {
  description = "CIDR block allowed to SSH into EC2"
  default     = "0.0.0.0/0"
}

variable "instance_count" {
  description = "Number of EC2 instances to launch"
  default     = 2
}

