
namespace Indexers
{
	struct Name
	{
        private string name;

		public Name(string text)
		{
			this.name = text;
		}

		public string Text
		{
			get { return this.name; }
		}

		public override int GetHashCode()
		{
			return this.name.GetHashCode();
		}

		public override bool Equals(object other)
		{
			return (other is Name) && Equals((Name)other);
		}
		
		public bool Equals(Name other)
		{
			return this.name == other.name;
		}
	}
}