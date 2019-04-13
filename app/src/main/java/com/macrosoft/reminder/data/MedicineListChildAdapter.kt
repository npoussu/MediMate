package com.macrosoft.reminder.data

/*
class MedicineListChildAdapter(private val medicineList: List<MedicineListData>) :
    RecyclerView.Adapter<MedicineListChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MedicineListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(medicineList[position])

    inner class ViewHolder(val binding: MedicineListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicineListData) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}
*/